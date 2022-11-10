# Subnetting

## IP

Reason for it: have an adress to send data to. Each PC needs to have an IP.

Every IP contains 1) a network ID and 2) a host ID. These are identified by the subent mask.

IP:             172 16  0   10

Network ID:     172 16  0   0

Host ID:        0   0   0   10

Network adress: 172 16  0   0

Broadcast:      172 26  255 255

## Subnetting - detail

Dividing a network into smaller pieces.

Example: Divide into 2:

CIDR: 172.16.0.0/16

IP Adress:  172 16 0 10

Subnetmask: 255 255 0 0

Network 1: 172.16.0.0/17

Network 2: 172.16.128.0/17
(Note the /17. We add a 1 into the subnet mask to divide the networks, that turns it from /16 into /17)

