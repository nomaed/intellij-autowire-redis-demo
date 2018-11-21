# Instructions

Please note that Java 10+ is required for this demo.

---

Step 1: clone the project:

```
git clone https://github.com/nomaed/intellij-autowire-redis-demo.git
cd intellij-autowire-redis-demo
```

Step 2: build/run to see that there are no actual issues

```
./gradlew build
./gradlew bootRun
```

Step 3: Open project in IntelliJ to see that there is an error in the editor.

Edit file [src/main/java/com/nomaed/debug/redistemplateintellij/DemoApplication.java](https://github.com/nomaed/intellij-autowire-redis-demo/blob/master/src/main/java/com/nomaed/debug/redistemplateintellij/DemoApplication.java#L20)

See the issue:

![Screenshot](https://raw.githubusercontent.com/nomaed/intellij-autowire-redis-demo/master/intellij-error.png)

![Tooltip](https://raw.githubusercontent.com/nomaed/intellij-autowire-redis-demo/master/error-text.png)
