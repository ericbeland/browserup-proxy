package com.browserup.bup.assertion.field.header;

import com.browserup.harreader.model.HarHeader;

import static org.apache.commons.lang3.StringUtils.contains;

public class HeadersContainStringAssertion extends HeadersPassPredicateAssertion {

    public HeadersContainStringAssertion(String value) {
        super(harHeaders -> harHeaders.stream()
                .filter(NONEMPTY_HEADER_FILTER)
                .map(HarHeader::getValue)
                .anyMatch(hv -> contains(hv, value)));
    }

    public HeadersContainStringAssertion(String name, String value) {
        super(harHeaders -> harHeaders.stream()
                .filter(NONEMPTY_HEADER_FILTER)
                .filter(h -> h.getName().equals(name))
                .anyMatch(h -> contains(h.getValue(), value)));
    }
}
