# Ars Janky ME Source Jar Compat

Ars Énergistique provides ME Source Jars that are supposed to work like Ars Nouveau's Source Jars except that they access the ME system's Source storage instead of having their own storage.
However, the ME Source Jars won't be recognized as Source Jars by Ars Nouveau machines that look for nearby Source Jars to deposit or withdraw source (e.g. Source Links, Enchanting Apparatuses, Depositor/Collector Relays, Starbunclemania's Source Condensers).

It sounds like this won't be addressed by Ars Énergistique in the current Minecraft release cycle (1.21.1) because it would require developing new systems that bring vast breaking changes in Ars Nouveau, needing extra time to get other Ars addons on board with them.

Since a post-1.21.1 Ars Nouveau release seems a long time off, in the meantime this mod tries to patch over that whole thing with this mod by jamming a very janky adapter into Ars Nouveau. It seems to work in my five minutes of testing, but it's liable to break as soon as either Ars Nouveau or Ars Énergistique make any sudden movements. I learned about mixins this week and now every problem looks like a nail.

Hopefully, in the next big release of Ars Nouveau, this mod will be obsolete.

Tested against NeoForge 21.1.219, Ars Nouveau 5.4.2.938, Ars Énergistique 2.1.1-beta.
