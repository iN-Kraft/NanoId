# NanoId

> [!IMPORTANT]
> Read the full documentation on the iNKraft website.  
> https://datlag.dev/libraries/nanoid/

A Kotlin Multiplatform port of [this JavaScript library](https://github.com/ai/nanoid), providing a fast, secure and URL-friendly unique ID generator.

## 🎯 Supported Targets

The following targets are supported:

| Platform           | Targets                                  |
|:-------------------|:-----------------------------------------|
| **JVM & Android**  | `jvm`, `android`                         |
| **Apple**          | `ios`, `macos`, `tvos`, `watchos`        |
| **Web**            | `js`, `wasmJs`                           |
| **Native & Other** | `linux`, `mingw`                         |

## ✨ Features

NanoId comes with several features while beeing fully customizable.

### 🔒 Secure

NanoId uses Korlibs [Crypto SecureRandom](https://github.com/korlibs/korlibs-crypto) to generate cryptographically strong random IDs with a proper distribution of characters.

Crypto provides a `SecureRandom` class that extends the `kotlin.random.Random` class, but generating cryptographic secure values.

- It uses `SecureRandom` on the JVM + `PRNGFixes` on Android.
- On Native POSIX (including Linux, macOS, iOS) it uses `/dev/urandom`
- On Windows `BCryptGenRandom` is in use

### 📦 Compact

NanoId generates compact IDs with just 21 characters.

By using a larger alphabet than UUID, NanoId can generate a greater number of unique IDs, when compared to UUID, with fewer characters (21 vs 36).

### 🖌️ Customizable

NanoId is fully customizable.

All default options may be overridden. Supply your own Random Number Generator, alphabet or size.
