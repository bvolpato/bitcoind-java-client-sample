package org.brunocvcunha.bitcoind;

import java.math.BigDecimal;

import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.BlockChainInfo;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.MiningInfo;

/**
 *
 * Bitcoind Sample
 *
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class BitcoindMain {

    public static void main(String[] args) throws Exception {

        BitcoindRpcClient rpcClient = new BitcoinJSONRPCClient("http://bitcoinrpc:rpcpassword@localhost:18332");
        rpcClient.setTxFee(new BigDecimal(0.001).setScale(3, BigDecimal.ROUND_DOWN));

        MiningInfo info = rpcClient.getMiningInfo();
        System.out.println("Mining Information");
        System.out.println("------------------");
        System.out.println("Chain......: " + info.chain());
        System.out.println("Blocks.....: " + info.blocks());
        System.out.println("Difficulty.: " + info.difficulty());
        System.out.println("Hash Power.: " + new BigDecimal(info.networkHashps()).toPlainString());

        String address = rpcClient.getNewAddress("Learning-Bitcoin-from-the-Command-Line");
        System.out.println("New Address: " + address);

        String privKey = rpcClient.dumpPrivKey(address);
        System.out.println("Priv Key: " + privKey);

        BlockChainInfo chainInfo = rpcClient.getBlockChainInfo();
        String blockHash = rpcClient.getBlockHash(chainInfo.blocks());

        System.out.println("Blockchain Info " + chainInfo);
        System.out.println("Block Hash: " + blockHash);

        System.out.println("Balance: " + rpcClient.getBalance());
    }
}
