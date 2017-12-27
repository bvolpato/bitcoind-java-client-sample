bitcoind-java-sample
========

[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/brunocvcunha/bitcoind-java-sample/blob/master/LICENSE)
[![Build Status](https://travis-ci.org/brunocvcunha/bitcoind-java-sample.svg)](https://travis-ci.org/brunocvcunha/bitcoind-java-sample)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](http://makeapullrequest.com)

:box: bitcoind-java-sample - Sample Project using Bitcoind API


Usage
--------

First of all, you need to setup your Bitcoind RPC server to have it ready to connect.
In case you need, the project [Learning Bitcoin from the Command Line](https://github.com/ChristopherA/Learning-Bitcoin-from-the-Command-Line) will guide you on how to setup a VPS server with a fully functional Bitcoin Core running.

After the server is setup, you can clone this project:

```
$ git clone https://github.com/brunocvcunha/bitcoind-java-client-sample
```

To be able to run it, you need to change the `BitcoindMain.java` file to match your server configurations (`rpcuser` and `rpcpassword` on the bitcoin.conf file), as well as the IP (8332 for mainnet, 18332 for testnet):
```java
BitcoindRpcClient rpcClient = new BitcoinJSONRPCClient("http://bitcoinrpc:rpcpassword@localhost:18332");
```

After the setup is done, you are able to execute the `BitcoindMain` class using the Maven `exec:java` goal:

```
mvn exec:java -Dexec.mainClass=org.brunocvcunha.bitcoind.BitcoindMain
```



bitcoind-java-sample requires at minimum Java 8.
