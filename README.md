# music-advisor
Music advisor that uses Spotify API

**The source code files of the project you can find in "music-advisor/Music Advisor/task/src"**

This is a training project from JetBrains Academy (Hyperskill).  
Authorization in Spotify proceeds via the OAuth 2.0 protocol.
Responses from the Spotify API come in JSON format.
Then responses are parsed by GSON library. 

### Usage
This is a console application, so user interacts with an application by commands.
Firstly, the user needs to authorize (provide the application rights to use some data of his Spotify account). 
He uses console command "auth" for this. The application will output an authorization link. 
After the user gives a permit to the application, he can use next commands:  
**new** - show new releases (title, artists, link)  
**featured** - featured playlists (title, link)  
**categories** - all available categories in Spotify  
**playlists categoryName** - playlists by a certain category (categoryName is an argument)  
**next** - show next elements of the response  
**prev** - show previous elements of the response  
**exit**