# Spring AI Chat Client Api

Spring AI Chat Client Api with Ollama/Llama3.2

---------
### Tech:

---------


Application uses ollama dependency. There is a compose file for working with ollama docker. No need to run compose file separately.
Running application be enough.

---------

### Business:

This application was written with reference to the [spring ai chat client api documentation](https://docs.spring.io/spring-ai/reference/1.0/api/chatclient.html).

You can demonstrate chat client api's different features with this application.

You can call chat client api via rest api and shell command.

---------

<b>Examples:</b>

Rest:
<br>
`curl -G http://localhost:8080/ai/chat -d "message=What%20is%20the%20capital%20of%20France"`
<br>
`The capital city of France is Paris.`

<br>
Shell Command:
<br>

```
shell:>q "What is the capital of France?"
The capital city of France is Paris.
```

