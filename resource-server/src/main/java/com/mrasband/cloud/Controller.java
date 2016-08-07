package com.mrasband.cloud;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/foo")
public class Controller {
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER1')")
    public String readFoo() {
        return "read FOO " + UUID.randomUUID().toString();
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String writeFoo() {
        return "write FOO " + UUID.randomUUID().toString();
    }
}
