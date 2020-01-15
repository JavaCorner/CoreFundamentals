package com.ab.core.reflection;

import com.ab.core.annotation.WorkHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkDispatchDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("1234");
        startWork("com.ab.core.reflection.AccountWorker", bankAccount);
        newStartWork("com.ab.core.reflection.NewAccountWorker", bankAccount);
        newAnnotationStartWork("com.ab.core.reflection.NewAccountWorker", bankAccount);
    }

    private static void newAnnotationStartWork(String workerTypeName, Object workerTarget) {
        try {
            Class<?> workerType = Class.forName(workerTypeName);
            TaskWorker taskWorker = (TaskWorker) workerType.newInstance();
            taskWorker.setTarget(workerTarget);

            WorkHandler workHandler = workerType.getAnnotation(WorkHandler.class);

            if(workHandler.useThreadPool()){
                ExecutorService executorService = Executors.newFixedThreadPool(5);
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        taskWorker.doWork();
                    }
                });
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void newStartWork(String workerTypeName, Object workerTarget) {
        try {
            Class<?> workerType = Class.forName(workerTypeName);
            TaskWorker taskWorker = (TaskWorker) workerType.newInstance();
            taskWorker.setTarget(workerTarget);
            taskWorker.doWork();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void startWork(String workerTypeName, Object workerTarget) {
        try {
            Class<?> workerType = Class.forName(workerTypeName);
            Class<?> targetType = workerTarget.getClass();

            Constructor<?> workerTypeConstructor = workerType.getConstructor(targetType);
            Object worker = workerTypeConstructor.newInstance(targetType);
            Method doWork = workerType.getMethod("doWork");
            doWork.invoke(worker);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
