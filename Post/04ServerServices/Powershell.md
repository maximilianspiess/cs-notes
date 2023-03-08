# Powershell Advanced

## Important Commands

### ExecutionPolicy

`Get-ExecutionPolicy` to get your current ExPol. And `Set-ExecutionPolicy: Restricted | Unrestricted | RemoteSigned` to set it.

### PS Session

You can remote into a PS Session with `New-PSsession -ComputerName [IP] -Credential $cred` (you can save this session with `$session =`)

If you want to execute something there in a script, do `Invoke-command -Session $session -Script{Get-service}` This allows you to do something on that session without having to go into the session.

At the end, remember to `Remove-PSSession $session` or `Remove -PSSession *`.

-----

## DHCP

(DynHosConProt) Assigns IP addresses to whoever asks. Can also give DNS Server, Time, Standard Gateway, etc.

### Scope

Contains the config od the domain.

### Lease time

Defines how long an IP will be reserved for a client. Client is identified by MAC. 

### Reservation

The DCHP reserves an address for a client. This can be useful to keep a client at a specific address for a longer time, like a server or a printer.

CARE! If two clients get the same address, they are taken off the network. That's why setting a fixed IP is not enough. Reserving it is also necessary.

### Relay Agent

In case the client is in a subnet, a relay agent is necessary to get to the client.

### Superscope

If available IPs run out, you can extend the the network and get more IPs that were initially outside of the scope.

-----

## Routing

