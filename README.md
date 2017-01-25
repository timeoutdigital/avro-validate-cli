### Avro validator

Given two schema files this tool will tell you whether data _written_ using one schema can be _read_ by a consumer using another schema.

It is useful when you want to make sure that any schema changes you're making will be backwards compatible.


Example usage:

```bash
java -jar avro-validate.jar new-schema.json old-schema.json
```

Will tell you whether a producer using `new-schema.json` will produce avro records that can be read by a consumer using `old-schema.json`
