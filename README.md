

# JavaCard Hello World

These are notes and code that I've organized to assist in JavaCard development. I'm using JavaCard 3.2 on Windows. Thile there is a lot of JavaCard documentation available on Oracle's site, there are also a lot of decision points to be made when reading the documentation. Ex: If you are using Windows, do this, if Linux, do that. I'm happy-pathing a way from code to card simulator and to a card. The objective here is to get results fast at the cost of understanding, and then use that working system as a tool for exploring various aspects of Java Card development in any order. 

## Decisions I've made for you
    * I'm using Windows
    * Visual Studio Code will be the primary editor
    * The SCP Symetric Keys are 111...111, 222...222, and  333...333 (64 chars in length each)
    * We will use `c:\shares\bin\java\javacard` as the root folder for the other Card SDK components
    * For a Physical Card, I'll be using a 95 Kb card from SmartCardFocus - https://www.smartcardfocus.com/shop/ilp/id~862/acosj-dual-interface-java-card-95k/p/index.shtml

    
    Using the GP tools to copy code to the card ( https://github.com/martinpaljak/GlobalPlatformPro )


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
SETX JC_HOME_TOOLS     C:\shares\bin\java\javacard\java_card_devkit_tools-bin-v24.0-b_57-20-FEB-2024
```

# Copying Code to a Card

## Environment Variables

Keys will be needed for certain operations on the card. You'll need to check with the manufacturer of your card to know what the keys are. The keys could be passed to the program that is writing to the card either on the command prompt, or through environment variables. 

 * `GP_KEY_ENC`
 * `GP_KEY_MAC`
 * `GP_KEY_DEK`
 * `GP_KEY`

The command for the command for copying code to the card would look something like this. 

`gp.exe -install myProgram.cap`


CDKenc: 90379AЗE7116D455E55F9398736A01CA 
CDKmac: 473F36161A7F7F60CC3A766EA4BE5247 
CDKkek: D3749ED4FF42FD58B39EEB562B017CD9 

* kek - Key encryption key. Used to encrypt other keys. 
* mac - message authentication code
* dek - data encryption key


I generally find that cleaner looking. For those that are curious, if you wanted to pass the the key information through the command line would use a command that looks like the following. 
`gp.exe -install myProgram.cap --key-enc HexBytes:1111111111111111111111111111111111111111111111111111111111111111 --key-mac HexBytes:2222222222222222222222222222222222222222222222222222222222222222 --key` 
