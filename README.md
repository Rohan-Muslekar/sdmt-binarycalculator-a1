# Binary Calculator

ENGR 5520G (Software Design Methods and Tools), Lab 1

A Maven-managed Java application that stores unsigned binary numbers as strings
and performs operations on them. The starter `Binary` class provided a
validating constructor, `getValue()`, and `add`. This assignment adds three
static operations:

- **`or`**: bitwise logical OR
- **`and`**: bitwise logical AND
- **`multiply`**: multiplication via shift-and-add (reuses `add`)

## Deliverables

- **Report:** [REPORT.md](REPORT.md)
- **Demo video:** _<paste 3-minute video link here>_

## Prerequisites

- JDK 11 (or any JDK meeting Maven's minimum)
- Apache Maven 3.9.9

Verify both are on the PATH:

```
java -version
mvn -version
```

### Installing Maven (Linux / WSL)

```
curl -fsSLO https://archive.apache.org/dist/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz
tar xzf apache-maven-3.9.9-bin.tar.gz -C $HOME
```

Then add these to your shell profile (`~/.zshrc` or `~/.bashrc`) and open a new
terminal:

```
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
export M2_HOME=$HOME/apache-maven-3.9.9
export PATH=$M2_HOME/bin:$PATH
```

On Windows, extract the same binary zip and set `JAVA_HOME` plus add Maven's
`bin` folder to the system PATH through Environment Variables.

## Build and run

Compile, test, and build a runnable JAR with dependencies bundled in:

```
mvn clean package assembly:single
```

Run the application (prints the current time via joda-time, then demonstrates
add, OR, AND, and multiply):

```
java -cp target/BinaryCalculator-1.0.0-jar-with-dependencies.jar com.ontariotechu.sofe3980U.App
```

## Run the tests

```
mvn test
```

Expected: `Tests run: 20, Failures: 0, Errors: 0, Skipped: 0`.

## Generate documentation

```
mvn site
```

Open `target/site/index.html` for the full site, or
`target/site/apidocs/index.html` for the Javadoc API docs (the three new methods
are documented under the `Binary` class).

## Project structure

```
BinaryCalculator/
├── pom.xml
├── src/main/java/com/ontariotechu/sofe3980U/
│   ├── App.java       # demo of add, OR, AND, multiply
│   └── Binary.java    # Binary class with or, and, multiply added
└── src/test/java/com/ontariotechu/sofe3980U/
    └── BinaryTest.java  # 20 JUnit tests
```
