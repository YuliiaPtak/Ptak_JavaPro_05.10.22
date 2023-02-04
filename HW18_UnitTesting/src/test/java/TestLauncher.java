import org.junit.Test;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class TestLauncher {

    @Test
    public void testLauncher() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage(""))
                .filters(includeClassNamePatterns(".*Test"))
                .build();

        TestExecutionListener listener = new SummaryWriter();
        try (LauncherSession session = LauncherFactory.openSession()) {
            Launcher launcher = session.getLauncher();
            launcher.registerTestExecutionListeners(listener);

            TestPlan testPlan = launcher.discover(request);
            launcher.execute(testPlan);
        }
    }
}
