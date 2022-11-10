# Netwokork components

## OSI-Model

PDNTSPA: 7 Layers, from physical to application. That's the path data takes to go from one client to the other.

## Network Card

- Is inside a PC or on the Mainboard.
- Connects OSI1 to OSI2
- Has a MAC adress

Uses: PC Onboard/external, server, router.

Who needs it?:

- People with a server
- People who want to increase their PC's capacity

Manufacturers: Zyxel, ASUS, QNAP, Intel

Price range:

- Pro: up to 8800.-
- Common: about 140.-
- Cheap: 12.-

## Network repeater

Function: signal repeater (duh). It increases the range of a signal. This allows to use a signal over a longer distance and remove any noise.

Can be analog, digital, wired, wireless, local, remote and increse ethernet, wlan, phone and ---- signals.

Where is it used?:

- Big companies
- People with a house
- Hotels
- Schools

Who makes it?:

- TP Link, Fritzbox, D Link and Netgear.

How much does it cost?:

- Simple: 53.-
- Mid: 120.-
- Top: 189.-

## Network hub

Function: Connect a device over ethernet to a network. The hub is connected to a server and all devices connect to the hub. You can also daisy chain hubs to increase capacity and range. They are quite old and not in use anymore; replaced by the **switch**.

Why not in use?:
The problame with them was: whatever was sent onto it, was sent to **everyone**. This created a lot of collisions and sucked.

OSI Layer: Layer 1. Just transmitting data.

Who uses it:

- People who want to extend an older network

How much does it cost?:

- hard to find, but cheaper than switches.

Who makes it (or used to)?:
3 com, Cisco and Netgear

## Network Bridge

Function: Connects just like a hub, but is actually smart.
MAC-Bridge: It separates the network into collision domains where users are registered. Any data is sent directly to the domain where the user is located.

LLC-Bridge: Connects two sub-networks and does translation between them.

OSI Layer: 2nd. Decide how data is packeted.

Who uses it?:

- Anywhere, where you need to connect (bridge) multiple LAN Networks: Office, House, Airport, Hotel

How much does it cost?: Between x and y

Who makes them?: Siwsscom, Netgear and Cisco.

## Network Switch

Function: Like a hub but smart (basically a multiport bridge). It allows to distribute a network and to target clients individually. It is bidirectional, therefore no collisions occur.

OSI Layer: 2 and 3.

Who uses it:

- People who make a VLAN (Virtual LAN)
- People who need more LAN Ports
- People with PoE devices
- Wherever you need to connect multiple devices and target them individually.

Where is it used?:

- Data center, big offices, privats (small ones), big networks in general.

How much do they cost?:

- cheap: 20.-
- normal: 100.-
- pro: 1500.-

Who makes them?: Ubiquiti, Netgear, Cisco, and someone else.

## Network Access Point

Function: Wireless conncection to endpoints (clients). Can be used to extend a WLAN. It's not a simple repeater!

OSI-Layer: Layer 2. Not 1, because it's not cable-cable but ehternet-WLAN.

Who uses it?:

- Someone who needs to cover a big area
- Someone who needs to extend their routers range

Where is it used?:

- Big buildings
- Offices
- Public buildings

How much does it cost?:

- Cheap: 25.-
- Normal: 370.-
- Pro 170.000.-

Who makes it?: Ubiquiti, Zyxel and TP-Link

## Network Router

Function: Turn the WAN signal from the modem into a LAN. This can be a wireless connection as well. It takes care of the data communication and routing inside of a network. It also separates multiple LAN connections and connects them.

OSI-Layer: Layer 3.

Who needs it?:

- Pretty much anyone who wants a connection to the internet (not mobile).

Where is it used?:

- Everywhere where there is a connection to the internet (not mobile).

How much does it cost?:

- cheap: as of 5.-
- normal: 40 to 100.-
- pro: 150.000 .- (was actually an access point lel)

Who makes it?: ASUS, Telekom, Huawei, Fritzbox, Netgear, Cisco and Linksys.

## Firewall

Function: Divides networks and applies safety measures to connections between them. Acronym IDS: Intrustion Detection System.
There are different types:

- Package filter: OSI2 and OS3. Filters what comes in
- Proxy Firewall: OSI1 to OSI7. Is between client and server.
- Stateful Inspection Firewall
- Application Gateway: OSI2 to OSI7 looks into packages and decides if safe or not. If not, blocks packet's access to OS.

Who needs it?:

- Anyone who wants to be safe on the net.
- Privates don't necessarliy need a **physical** one.

Where is it used?:

- big companies

How much does it cost?:

- from 200.- to 100.000.- +

Who makes it?: zyxel, draytek, fortigate, Watchguard, Cisco, Sonicwall
