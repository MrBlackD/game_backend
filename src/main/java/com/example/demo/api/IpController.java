package com.example.demo.api;

import com.example.demo.dto.Ip;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

@RestController
public class IpController {

    @GetMapping("/ip")
    @CrossOrigin(origins = "http://localhost:3000")
    public Ip get() throws SocketException {
        System.out.println("GET IP");
        Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
        while (e.hasMoreElements()) {
            NetworkInterface n = e.nextElement();
            Enumeration<InetAddress> ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = ee.nextElement();
                System.out.println("ip = " + i.getHostAddress());
                if (i.getHostAddress().startsWith("192.168.")) {
                    return new Ip(i.getHostAddress());
                }
            }
        }
        return new Ip("192.168.0.110");
    }
}
