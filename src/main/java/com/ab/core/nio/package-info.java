package com.ab.core.nio;

/**
 * @author Arpit Bhardwaj
 *
 * Four fundamental classes are abstract
 *      Reader:         read characters
 *      Writer:         write characters
 *      InputStream:    read bytes
 *      OutputStream:   write bytes
 *
 * The above classes knows
 *      the direction whether reading or writing
 *      the data whether character or bytes
 *  only source whether(on disk, network, inmemory) is abstract to it. Hence, low level imple decides what could be the source
 *
 * Low level implementation of Reader
 *      FileReader : disk reader
 *      StringReader : in memory
 *      CharArrayReader : in memory
 *
 *      In Memory readers support marking and resetting
 *
 * Low level implementation of Writer
 *      FileWriter : disk writer
 *      StringWriter : in memory (doesn't violate string immutable, write internally in buffer)
 *      CharArrayWriter : in memory
 *      PrintWriter
 *
 *      In Memory writers support marking and resetting
 *
 * Low level implementation of InputStream
 *      FileInputStream
 *      ByteArrayInputStream
 *
 * Low level implementation of OutputStream
 *      FileOutputStream
 *      ByteArrayOutputStream
 *      PrintStream
 *
 * High Level Implementation
 *
 * Adding buffering
 *      BufferedReader
 *          LineNumberReader: A buffered character-input stream that keeps track of line numbers.
 *      BufferedWriter
 *      BufferedInputStream
 *      BufferedOutputStream
 *
 * APIs that act as bridge between characters and bytes.
 *      OutputStreamWriter : Eventually a writer built upon outputstream
 *      InputStreamReader : Eventually a reader built upon inputstream
 *
 * Specific Streams for primitives
 *      DataInputStream
 *      DataOutputStream
 *
 * Specific strems for objects
 *      ObjectInputStream
 *      ObjectOutputStream
 *
 */