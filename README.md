[![Maven Central](https://img.shields.io/maven-central/v/io.github.du00cs/json-repairj.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.du00cs%22%20AND%20a:%22json-repairj%22)
[![Build](https://github.com/du00cs/json-repairj/actions/workflows/test.yml/badge.svg)](https://github.com/du00cs/json-repairj/actions/workflows/test.yml)

# json-restore

A java library to restore broken JSON strings, useful for repairing malformed JSON output from Large Language Models.

## Setup

To be updated..


## Usage

```java
import org.jsonrestore.JsonRestore;

String result = JsonRepair.restoreJson(str);

// or more control (result = jackson node + warnings)
ParseResult result = JsonRepair.parseJson(str, skipLoads, streamStable);
```

## Not Implemented

Some features are not implemented yet:
- identity check in multiple json
- read from file
- stream stable not tested

## License

[MIT](/LICENSE.md)