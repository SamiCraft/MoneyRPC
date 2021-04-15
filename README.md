# MoneyRPC

MoneyRPC is a minecraft **fabric mod**. It enables you to display your real time balance on the Samifying's HideySMP
Minecraft server

### Installation

Before we get started you need to make sure you have a **Fabric Mod Loader** installed on your client. To dowlonad the Fabric Mod Loader go to this link here:

- [Fabric Mod Loader Download Page](https://fabricmc.net/use/)

When you download the right version (I always recommend that you download the **Universal/JAR** but its on you to decide)

Please note that if you are installing fabric for the first time you might as well need a Java runtime too! You can dowload Java 8 runtime from this link:

- [Oracle Java 8 Download Page](https://www.java.com/en/download/)

When you have installed the fabric mod loader, start it for the first time. When game loads just quit it. You have successfuly installed Fabric Mod Loader

Now you need to navigate to your minecraft installation folder, you can usually do it from `Launcher >> Installations` and when you hover over the Fabric proffile you will see a folder icon. When you click on it will open your file explorer. Open the `mods` folder

Now go to the [project releases](https://github.com/SamiCraft/MoneyRPC/releases) tab and download the `money-rpc-x.x.jar` (x represents the version) and copy it to your `mods` folder

You need to start the game now. We need to do this in order for the mod to create config files. When game loads exit it

Now go one folder back from the `mods`, you will be able to now find the file called `moneyrpc.properties`. Open it with you text editor

You will need to change the `discord.id` property to your personal discord id. You can get that by enabling [developer mode on Discord](https://discordia.me/en/developer-mode) or by going to the #bot-hole and typing in !myid and the SamiCraft bot will tell you what is your discord id. When you changed the id to yours save the file and start the game

***Congratulations, you have successfully set up the mod!!!***

### Troubleshooting

Before we proceed please make sure that you can actually join the server, aka check if you have verified yourself.

If you are getting `Money: $Unknown` that means that ether your id was not found or that you have not verified or that there is a severe server error. Go and verify again, or at least check if bot can find you in the database with **!whois discord your-discord-id**

For more help please pm me on discord: **Pequla#3038**
