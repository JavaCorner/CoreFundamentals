package com.ab.core.security;

/**
 * @author Arpit Bhardwaj
 *
 * Security Threats
 *      Sensitive data leaks
 *      Injection
 *      Inclusion (Ex. zip bomb or the billion laughs attack)
 *      DoS Attacks
 *      Code corruption
 *
 * Prevent Sensitive Data Leaks
 *      When logging:
 *          Don’t log unnecessarily, avoid sensitive information
 *          Use log correlators or hashed info
 *          Avoid logging entire objects and printf
 *      With memory:
 *          All data on the heap is visible
 *          Don’t cache unnecessarily, avoid sensitive information
 *      With exceptions:
 *          Don’t show exceptions
 *          Replace untrusted exception messages
 *
 * Prevent Injections
 *      Don't output untrusted data
 *      canonicalize and validate inputs
 *      encode outputs
 *      used an appropriately configured third party
 *
 * Prevent Inclusions - occur when multiple files or components are embedded within a single entity
 *      Don't use untrusted input to load resources.
 *      Load resources locally, using allow list
 *      Load remote resources over HTTPS, using an allowlist
 *      Use an appropriately-configured third party
 *
 * Prevent DoS
 *      Mitigate inclusion
 *      Define and enforce limits on external and internal resources
 *              Java defines and enforces a limit on heap size
 *              Java XMl defines and enforces a limit on entity expansion
 *      Account for overflow
 *      Close resouces (locks and io streams etc.)
 *      Pool expensive resources
 *
 * Preventing Code corruption
 *      Enforce tight encapsulation
 *      Make objects as immutable as possible
 *      Do not break subclass assumption about inherited code
 *      Design classes and methods for inheritance or declare them final
 *      protect byte code against tempering and dangerous behaviour
 *
 * Overall best security practices
 *      Keep Code Simple
 *      Avoid Duplication
 *      Minimize Permission Checks
 *      Document Security
 *      Secure Third-party Code
 *
 * Best security practices while designing objects
 *      Encapsulation
 *      Immutability
 *      Input Validation
 *      Avoid Clonable and Serializable
 *      Secur Serialization via
 *          by overriding readResolve
 *          by overriding readObject and writeObject
 *          configure security checks using ObjectInputFilter
 *
 */