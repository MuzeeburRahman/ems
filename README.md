# ems-Employee Management System
## Technical Stack
Technology | 
--- |
Java8 | 
Springboot-2.5.7 | 
gradle-7.2 | 
Spring data-jpa |
H2 |
## SetUp the Application
Clone the the project from Git 
https://github.com/MuzeeburRahman/ems
- Step1: git clone https://github.com/MuzeeburRahman/ems.git
- Stept2: User/git/ems:$  **./gradlew clean build**
- Stept2: User/git/ems:$  **./gradlew bootRun**
##  Application URLS
- [OpenAPi Swagger](http://localhost:8080/swagger-ui-ems.html)
- [h2 Console](http://localhost:8080/h2)
- [actuator health](http://localhost:8080/actuator/health)
##### Note: Please add department before employee
## Design Specification
### System Architcure
![alt text](https://github.com/MuzeeburRahman/ems/blob/main/ems-%20arch.png?raw=true)
### API interface document 
```json
{
   "openapi":"3.0.1",
   "info":{
      "title":"Employee Managment System",
      "description":"@project.description@:Employee Managment System",
      "version":"@project.version:0.0.1-SNAPSHOT"
   },
   "servers":[
      {
         "url":"http://localhost:8080",
         "description":"Generated server url"
      }
   ],
   "paths":{
      "/employees":{
         "get":{
            "tags":[
               "employee-controller"
            ],
            "operationId":"getAllEmployees",
            "responses":{
               "400":{
                  "description":"Bad Request",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.exception.ValidationErrorResponse"
                        }
                     }
                  }
               },
               "200":{
                  "description":"OK",
                  "content":{
                     "*/*":{
                        "schema":{
                           "type":"array",
                           "items":{
                              "$ref":"#/components/schemas/com.etek.ems.entity.Employee"
                           }
                        }
                     }
                  }
               }
            }
         },
         "post":{
            "tags":[
               "employee-controller"
            ],
            "operationId":"createOrUpdateEmployee",
            "requestBody":{
               "content":{
                  "application/json":{
                     "schema":{
                        "$ref":"#/components/schemas/com.etek.ems.entity.Employee"
                     }
                  }
               },
               "required":true
            },
            "responses":{
               "400":{
                  "description":"Bad Request",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.exception.ValidationErrorResponse"
                        }
                     }
                  }
               },
               "200":{
                  "description":"OK",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.entity.Employee"
                        }
                     }
                  }
               }
            }
         }
      },
      "/deparments":{
         "get":{
            "tags":[
               "deparment-controller"
            ],
            "operationId":"getAllEmployees_1",
            "responses":{
               "400":{
                  "description":"Bad Request",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.exception.ValidationErrorResponse"
                        }
                     }
                  }
               },
               "200":{
                  "description":"OK",
                  "content":{
                     "*/*":{
                        "schema":{
                           "type":"array",
                           "items":{
                              "$ref":"#/components/schemas/com.etek.ems.entity.Department"
                           }
                        }
                     }
                  }
               }
            }
         },
         "post":{
            "tags":[
               "deparment-controller"
            ],
            "operationId":"createOrUpdateEmployee_1",
            "requestBody":{
               "content":{
                  "application/json":{
                     "schema":{
                        "$ref":"#/components/schemas/com.etek.ems.entity.Department"
                     }
                  }
               },
               "required":true
            },
            "responses":{
               "400":{
                  "description":"Bad Request",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.exception.ValidationErrorResponse"
                        }
                     }
                  }
               },
               "200":{
                  "description":"OK",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.entity.Department"
                        }
                     }
                  }
               }
            }
         }
      },
      "/employees/{id}":{
         "get":{
            "tags":[
               "employee-controller"
            ],
            "operationId":"getEmployeeById",
            "parameters":[
               {
                  "name":"id",
                  "in":"path",
                  "required":true,
                  "schema":{
                     "type":"integer",
                     "format":"int64"
                  }
               }
            ],
            "responses":{
               "400":{
                  "description":"Bad Request",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.exception.ValidationErrorResponse"
                        }
                     }
                  }
               },
               "200":{
                  "description":"OK",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.entity.Employee"
                        }
                     }
                  }
               }
            }
         },
         "delete":{
            "tags":[
               "employee-controller"
            ],
            "operationId":"deleteEmployeeById",
            "parameters":[
               {
                  "name":"id",
                  "in":"path",
                  "required":true,
                  "schema":{
                     "type":"integer",
                     "format":"int64"
                  }
               }
            ],
            "responses":{
               "400":{
                  "description":"Bad Request",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.exception.ValidationErrorResponse"
                        }
                     }
                  }
               },
               "200":{
                  "description":"OK",
                  "content":{
                     "*/*":{
                        "schema":{
                           "type":"string",
                           "enum":[
                              "100 CONTINUE",
                              "101 SWITCHING_PROTOCOLS",
                              "102 PROCESSING",
                              "103 CHECKPOINT",
                              "200 OK",
                              "201 CREATED",
                              "202 ACCEPTED",
                              "203 NON_AUTHORITATIVE_INFORMATION",
                              "204 NO_CONTENT",
                              "205 RESET_CONTENT",
                              "206 PARTIAL_CONTENT",
                              "207 MULTI_STATUS",
                              "208 ALREADY_REPORTED",
                              "226 IM_USED",
                              "300 MULTIPLE_CHOICES",
                              "301 MOVED_PERMANENTLY",
                              "302 FOUND",
                              "302 MOVED_TEMPORARILY",
                              "303 SEE_OTHER",
                              "304 NOT_MODIFIED",
                              "305 USE_PROXY",
                              "307 TEMPORARY_REDIRECT",
                              "308 PERMANENT_REDIRECT",
                              "400 BAD_REQUEST",
                              "401 UNAUTHORIZED",
                              "402 PAYMENT_REQUIRED",
                              "403 FORBIDDEN",
                              "404 NOT_FOUND",
                              "405 METHOD_NOT_ALLOWED",
                              "406 NOT_ACCEPTABLE",
                              "407 PROXY_AUTHENTICATION_REQUIRED",
                              "408 REQUEST_TIMEOUT",
                              "409 CONFLICT",
                              "410 GONE",
                              "411 LENGTH_REQUIRED",
                              "412 PRECONDITION_FAILED",
                              "413 PAYLOAD_TOO_LARGE",
                              "413 REQUEST_ENTITY_TOO_LARGE",
                              "414 URI_TOO_LONG",
                              "414 REQUEST_URI_TOO_LONG",
                              "415 UNSUPPORTED_MEDIA_TYPE",
                              "416 REQUESTED_RANGE_NOT_SATISFIABLE",
                              "417 EXPECTATION_FAILED",
                              "418 I_AM_A_TEAPOT",
                              "419 INSUFFICIENT_SPACE_ON_RESOURCE",
                              "420 METHOD_FAILURE",
                              "421 DESTINATION_LOCKED",
                              "422 UNPROCESSABLE_ENTITY",
                              "423 LOCKED",
                              "424 FAILED_DEPENDENCY",
                              "425 TOO_EARLY",
                              "426 UPGRADE_REQUIRED",
                              "428 PRECONDITION_REQUIRED",
                              "429 TOO_MANY_REQUESTS",
                              "431 REQUEST_HEADER_FIELDS_TOO_LARGE",
                              "451 UNAVAILABLE_FOR_LEGAL_REASONS",
                              "500 INTERNAL_SERVER_ERROR",
                              "501 NOT_IMPLEMENTED",
                              "502 BAD_GATEWAY",
                              "503 SERVICE_UNAVAILABLE",
                              "504 GATEWAY_TIMEOUT",
                              "505 HTTP_VERSION_NOT_SUPPORTED",
                              "506 VARIANT_ALSO_NEGOTIATES",
                              "507 INSUFFICIENT_STORAGE",
                              "508 LOOP_DETECTED",
                              "509 BANDWIDTH_LIMIT_EXCEEDED",
                              "510 NOT_EXTENDED",
                              "511 NETWORK_AUTHENTICATION_REQUIRED"
                           ]
                        }
                     }
                  }
               }
            }
         }
      },
      "/deparments/{departmentId}":{
         "get":{
            "tags":[
               "deparment-controller"
            ],
            "operationId":"getEmployeeById_1",
            "parameters":[
               {
                  "name":"departmentId",
                  "in":"path",
                  "required":true,
                  "schema":{
                     "type":"integer",
                     "format":"int64"
                  }
               }
            ],
            "responses":{
               "400":{
                  "description":"Bad Request",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.exception.ValidationErrorResponse"
                        }
                     }
                  }
               },
               "200":{
                  "description":"OK",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.entity.Department"
                        }
                     }
                  }
               }
            }
         }
      },
      "/deparments/{id}":{
         "delete":{
            "tags":[
               "deparment-controller"
            ],
            "operationId":"deleteEmployeeById_1",
            "parameters":[
               {
                  "name":"departmentId",
                  "in":"path",
                  "required":true,
                  "schema":{
                     "type":"integer",
                     "format":"int64"
                  }
               }
            ],
            "responses":{
               "400":{
                  "description":"Bad Request",
                  "content":{
                     "*/*":{
                        "schema":{
                           "$ref":"#/components/schemas/com.etek.ems.exception.ValidationErrorResponse"
                        }
                     }
                  }
               },
               "200":{
                  "description":"OK",
                  "content":{
                     "*/*":{
                        "schema":{
                           "type":"string",
                           "enum":[
                              "100 CONTINUE",
                              "101 SWITCHING_PROTOCOLS",
                              "102 PROCESSING",
                              "103 CHECKPOINT",
                              "200 OK",
                              "201 CREATED",
                              "202 ACCEPTED",
                              "203 NON_AUTHORITATIVE_INFORMATION",
                              "204 NO_CONTENT",
                              "205 RESET_CONTENT",
                              "206 PARTIAL_CONTENT",
                              "207 MULTI_STATUS",
                              "208 ALREADY_REPORTED",
                              "226 IM_USED",
                              "300 MULTIPLE_CHOICES",
                              "301 MOVED_PERMANENTLY",
                              "302 FOUND",
                              "302 MOVED_TEMPORARILY",
                              "303 SEE_OTHER",
                              "304 NOT_MODIFIED",
                              "305 USE_PROXY",
                              "307 TEMPORARY_REDIRECT",
                              "308 PERMANENT_REDIRECT",
                              "400 BAD_REQUEST",
                              "401 UNAUTHORIZED",
                              "402 PAYMENT_REQUIRED",
                              "403 FORBIDDEN",
                              "404 NOT_FOUND",
                              "405 METHOD_NOT_ALLOWED",
                              "406 NOT_ACCEPTABLE",
                              "407 PROXY_AUTHENTICATION_REQUIRED",
                              "408 REQUEST_TIMEOUT",
                              "409 CONFLICT",
                              "410 GONE",
                              "411 LENGTH_REQUIRED",
                              "412 PRECONDITION_FAILED",
                              "413 PAYLOAD_TOO_LARGE",
                              "413 REQUEST_ENTITY_TOO_LARGE",
                              "414 URI_TOO_LONG",
                              "414 REQUEST_URI_TOO_LONG",
                              "415 UNSUPPORTED_MEDIA_TYPE",
                              "416 REQUESTED_RANGE_NOT_SATISFIABLE",
                              "417 EXPECTATION_FAILED",
                              "418 I_AM_A_TEAPOT",
                              "419 INSUFFICIENT_SPACE_ON_RESOURCE",
                              "420 METHOD_FAILURE",
                              "421 DESTINATION_LOCKED",
                              "422 UNPROCESSABLE_ENTITY",
                              "423 LOCKED",
                              "424 FAILED_DEPENDENCY",
                              "425 TOO_EARLY",
                              "426 UPGRADE_REQUIRED",
                              "428 PRECONDITION_REQUIRED",
                              "429 TOO_MANY_REQUESTS",
                              "431 REQUEST_HEADER_FIELDS_TOO_LARGE",
                              "451 UNAVAILABLE_FOR_LEGAL_REASONS",
                              "500 INTERNAL_SERVER_ERROR",
                              "501 NOT_IMPLEMENTED",
                              "502 BAD_GATEWAY",
                              "503 SERVICE_UNAVAILABLE",
                              "504 GATEWAY_TIMEOUT",
                              "505 HTTP_VERSION_NOT_SUPPORTED",
                              "506 VARIANT_ALSO_NEGOTIATES",
                              "507 INSUFFICIENT_STORAGE",
                              "508 LOOP_DETECTED",
                              "509 BANDWIDTH_LIMIT_EXCEEDED",
                              "510 NOT_EXTENDED",
                              "511 NETWORK_AUTHENTICATION_REQUIRED"
                           ]
                        }
                     }
                  }
               }
            }
         }
      }
   },
   "components":{
      "schemas":{
         "com.etek.ems.exception.ValidationErrorResponse":{
            "type":"object",
            "properties":{
               "violations":{
                  "type":"array",
                  "items":{
                     "$ref":"#/components/schemas/com.etek.ems.exception.Violation"
                  }
               }
            }
         },
         "com.etek.ems.exception.Violation":{
            "type":"object",
            "properties":{
               "fieldName":{
                  "type":"string"
               },
               "message":{
                  "type":"string"
               }
            }
         },
         "com.etek.ems.entity.Department":{
            "type":"object",
            "properties":{
               "departmentId":{
                  "type":"integer",
                  "format":"int64"
               },
               "departmentName":{
                  "type":"string"
               },
               "managerId":{
                  "type":"integer",
                  "format":"int64"
               }
            }
         },
         "com.etek.ems.entity.Employee":{
            "required":[
               "firstname",
               "lastname",
               "salary"
            ],
            "type":"object",
            "properties":{
               "employeeId":{
                  "type":"integer",
                  "format":"int64"
               },
               "firstname":{
                  "type":"string"
               },
               "lastname":{
                  "type":"string"
               },
               "hireDate":{
                  "type":"string",
                  "format":"date-time"
               },
               "phoneNumber":{
                  "pattern":"^[\\d -]+$",
                  "type":"string"
               },
               "salary":{
                  "minimum":1,
                  "type":"number",
                  "format":"double"
               },
               "managerId":{
                  "type":"integer",
                  "format":"int64"
               },
               "email":{
                  "type":"string"
               },
               "department":{
                  "$ref":"#/components/schemas/com.etek.ems.entity.Department"
               }
            }
         }
      }
   }
}
```
### Data model ER
![alt text](https://github.com/MuzeeburRahman/ems/blob/main/ER.png?raw=true)
