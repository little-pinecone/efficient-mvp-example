package in.keepgrowing.efficientmvpexample.datainit.services;

import dev.codesoapbox.dummy4j.Dummy4j;

import java.util.List;

public class CustomDummy extends Dummy4j {

    public CustomDummy(Long seed, List<String> locales, List<String> paths) {
        super(seed, locales, paths);
    }
}
