# Routing

## What is it?

The guiding of information through a network to its destination.

## Routing decision

[INSERT TABLE]

## Routing table

Two ways to do it: static (manually) or dynamic (automatic).

### Static routing

Sit at the router and use `route add -net 10.10.10.0/24 gateway 192.168.4.100 dev eth1` to add a new route.

Pros:

- easy
- full controll
- no overhead

Cons:

- manual editing
- error prone
- lot of work on bid networks

### Dynamic routing

Routing table created automatically (based on protocols) like RIP, OSPF, IGRP, BGP, OLSR.

Pros:

- easy config
- no errors
- loadbalancing

Cons:

- ressource intensive
- route automatically selected


### Tools and commands

- (W) `route`: show current routing table
- (W) `ping`: check availability
- (W) `tracert`: show packet route
- (W) `netstat`: show protocols, ports and connections