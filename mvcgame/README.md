### .vscode/launch.json ###

```
{
    "configurations": [
        {
            "type": "java",
            "name": "CodeLens (Launch) - MvcGameJavaFxLauncher",
            "request": "launch",
            "mainClass": "cz.cvut.fit.miadp.MvcGameJavaFxLauncher",
            // TODO: fix these vmArgs paths to point to your Maven repository
            "vmArgs": "--module-path /Users/Petr/.m2/repository/org/openjfx/javafx-base/13/javafx-base-13-win.jar;/Users/Petr/.m2/repository/org/openjfx/javafx-base/13/javafx-base-13.jar;/Users/Petr/.m2/repository/org/openjfx/javafx-controls/13/javafx-controls-13-win.jar;/Users/Petr/.m2/repository/org/openjfx/javafx-controls/13/javafx-controls-13.jar;/Users/Petr/.m2/repository/org/openjfx/javafx-graphics/13/javafx-graphics-13-win.jar;/Users/Petr/.m2/repository/org/openjfx/javafx-graphics/13/javafx-graphics-13.jar --add-modules  javafx.base,javafx.controls,javafx.graphics -classpath /Users/Petr/Repos/miadp-mvcgame-b191/target/classes",
            "projectName": "mvcgame"
        }
    ]
}
```