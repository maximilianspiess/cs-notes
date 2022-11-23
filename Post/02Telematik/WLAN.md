# WLAN

## Channels

2.4 and 5.0 GHz. **ISMWLAN** is at 2.4 and **WLAN5GHZ** at 5.0.

## Radiation

Radiaton amounts depend on the transmitter's performance and distance. WLAN is about 1/1000 as radioactive as phones.

### ISM (Industrial, Scientific and Medial)

- 2.4 - 2.4835 GHz
  - also outdoor
  - max 100 mW
- (low) 5.15 - 5.35 GHz
  - only outdoors
  - max 200 mW, 100 mW without TCP
- (high) 5.47 - 5.725 GHz
  - also outdoors
  - mac 1000 mW with TCP, 500 mW without.

## Range

- WPAN: Wireless Personal Area Network (Bluetooth)
- WLAN: Wireless Local Area Network (Wifi)
- WWAN: Wireles Wide Area Network (Cellservice)

## Performance

### Interference

Many hosts on a single channel create interference. These interfere anothers networkds, microwaves or bluetooth. There's also a reduction of range via distance, walls or SNR (signal to noise ratio).

## Wifi Standards

### Wifi 5

- Automatic channel selection
- 20/40/80/160 MHz bandwidth --> 1 Stream tpo 20 MHz
- Up to 8 antennas simultanously
- Beamforming: send signals where devices are
- max 292.5 Mbit/s on phones
- 480 Mbit/s through USB 2.0

### Wifi 6

- MIMO-OFDM: **[FILL]**

## Network extensions

### Wifi Repeater

Expands the network, but reduces the bandwidth.

### Mesh network

Consists of multiple smaller access points, allowing for full speed transmission between node and router.

### Blanket technology

Multiple access points that synchronize over an access point switch, that use multiple SSID. The AP assign themselves their own channels corresponding to SSID.

## Laws

### What if someone logs into your network and does illegal activity?

Basically, as long as you didn't allow someone into your network, you're not liable for any activity they've done on it. Nowadays, IP addresses are not enough to identify a person, and as long as you can somehow prove that it wasn't your deivce, you're not guilty.

## Pros and Cons to Wifi

### Pros

- wireless
- fast development
- easy area coverage

### Cons

- security
- listening in

## SSID

Service Set IDentifier: basically telling what our network is called. 1 network == 1 SSID. This is mostly set by the manufacturer:

- CISCO: tsuname
- Lynksis: lynksis

You can change the SSID. This is good to hide the manufacturer and people's connections.

## MAC Filter

A MAC Filter tells which devices can join a network, depending on what their MAC address is.

Porblem?: MAC spoofing. Changing the MAC with software

## Encryption+

### WEP

Wired Equivalent Privacy.

This was the first encryption in the wireless area, based on RC4.

### WPA

Wifi Protected Access.

Saftery standard IEEE 802.11i was late, so... **[FILL]**

### WPA-PSK

Pre-Shared Key: a key that was predefined.

It has to be available on all nodes.

### WPA-EAP

Extensible Authentication Protocol -> Username & Password

### WPA2

Supports AES encryption, instead of RC4. It also supports 802.11i. There is a porblem though: KRACK, since 2017.

KRACK: after disconnecting the host, the reconnection happens with a connection vector 0, meaning that it is really easy to calculate the password afterwards.

### WPA3

Supports AES and 802.11i. It now uses only secure encryption (SAE simultaneus authentication of euqals). It's not possible to crack the password offile (zero-knowledge proof).

## What can you do to increase safety?

(from low to high)

- open SSID
- hidden SSID
- use a MAC filter
- use WEP
- use EAP
- use WPA or WPA2 (or above)

### Prevention

- Change standard password
- change SSID
- make devices not configurable over Wifi
- encrypt the data stream
- no remote configuration
- turn off access points when not in use

## What does the future hold?

Wifi 6E

- new 6 GHz
- 9.6 Gbps
- 8 spatial streams

Wifi 7

- 2.4, 5 and 6 GHz
- 46.1 Gbps
- 16 spatial streams
