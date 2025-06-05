

# JavaCard Hello World

These are notes and code that I've organized to assist in JavaCard development. I'm using JavaCard 3.2 on Windows. Thile there is a lot of JavaCard documentation available on Oracle's site, there are also a lot of decision points to be made when reading the documentation. Ex: If you are using Windows, do this, if Linux, do that. I'm happy-pathing a way from code to card simulator and to a card. The objective here is to get results fast at the cost of understanding, and then use that working system as a tool for exploring various aspects of Java Card development in any order. 

## Decisions I've made for you
    * I'm using Windows
    * Visual Studio Code will be the primary editor
    * The SCP Symetric Keys are 111...111, 222...222, and  333...333 (64 chars in length each)
    * We will use `c:\shares\java\javacard` as the root folder for the other Card SDK components


# Configuring the Environment Variables

Since I've made decisions for you, we can define our environment variables now even though we've not yet installed all the components that will be using them. 

- JC_HOME_SIMULATOR
- JAVA_HOME
- JC_HOME_TOOLS – Set to the installation path of Java Card Development Tools
- PATH 
    - the path variable must include the bin\ folder of the Java Development Kit installation
    - the path variable must include the bin\ folder of the MinGW installation.

```
SETX JC_HOME_SIMULATOR C:\shares\bin\java\javacard\java_card_devkit_simulator-win-bin-v24.0-b_55-20-FEB-2024
SETX JC_HOME_SIMULATOR C:\shares\bin\java\javacard\java_card_devkit_tools-bin-v24.0-b_57-20-FEB-2024
```


