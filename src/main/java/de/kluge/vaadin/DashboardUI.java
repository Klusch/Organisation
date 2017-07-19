package de.kluge.vaadin;

import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;

import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

import de.kluge.entities.User;
import de.kluge.vaadin.data.dummy.DummyDataProvider;
import de.kluge.vaadin.event.DashboardEvent.CloseOpenWindowsEvent;
import de.kluge.vaadin.event.DashboardEvent.UserLoggedOutEvent;
import de.kluge.vaadin.event.DashboardEvent.UserLoginRequestedEvent;
import de.kluge.vaadin.event.DashboardEventBus;
import de.kluge.vaadin.view.LoginView;
import de.kluge.vaadin.view.MainView;
import de.kluge.vaadin.event.DashboardEvent.BrowserResizeEvent;

@SpringUI(path="/dashboard")
@Theme("dashboard")
@Widgetset("com.vaadin.demo.dashboard.DashboardWidgetSet")
@Title("QuickTickets Dashboard")
@SuppressWarnings("serial")
public class DashboardUI extends UI {

	private static final long serialVersionUID = -7707593026624772383L;

    /*
     * This field stores an access to the dummy backend layer. In real
     * applications you most likely gain access to your beans trough lookup or
     * injection; and not in the UI but somewhere closer to where they're
     * actually accessed.
     */
//    private final DataProvider dataProvider = new DummyDataProvider();
    private final transient DashboardEventBus dashboardEventbus = new DashboardEventBus();

    // Entry point for vaadin
    @Override
    protected void init(final VaadinRequest request) {
        setLocale(Locale.GERMANY);

        DashboardEventBus.register(this);
        Responsive.makeResponsive(this);
        addStyleName(ValoTheme.UI_WITH_MENU);

        updateContent();

        Page.getCurrent().addBrowserWindowResizeListener(event -> DashboardEventBus.post(new BrowserResizeEvent()));
    }

    /**
     * Updates the correct content for this UI based on the current user status.
     * If the user is logged in with appropriate privileges, main view is shown.
     * Otherwise login view is shown.
     */
    private void updateContent() {
//        User user = (User) VaadinSession.getCurrent().getAttribute(
//                User.class.getName());
//        
//        user = new User();
//        user.setRole("admin");
//        
//        if (user != null && "admin".equals(user.getRole())) {
            // Authenticated user
            setContent(new MainView());
            removeStyleName("loginview");
//            getNavigator().navigateTo(getNavigator().getState());
//        } else {
//            setContent(new LoginView());
//            addStyleName("loginview");
//        }
    }

//    @Subscribe
    public void userLoginRequested(final UserLoginRequestedEvent event) {
    	// AK
    	User user = new User();
    	user.setUsername("xxxxxxx");
    	
//        User user = getDataProvider().authenticate(event.getUserName(),
//                event.getPassword());
        VaadinSession.getCurrent().setAttribute(User.class.getName(), user);
        updateContent();
    }

//    @Subscribe
    public void userLoggedOut(final UserLoggedOutEvent event) {
        // When the user logs out, current VaadinSession gets closed and the
        // page gets reloaded on the login screen. Do notice the this doesn't
        // invalidate the current HttpSession.
        VaadinSession.getCurrent().close();
        Page.getCurrent().reload();
    }

//    @Subscribe
    public void closeOpenWindows(final CloseOpenWindowsEvent event) {
        for (Window window : getWindows()) {
            window.close();
        }
    }

    /**
     * @return An instance for accessing the (dummy) services layer.
     */
//    public static DataProvider getDataProvider() {
//        return ((DashboardUI) getCurrent()).dataProvider;
//    }

    public static DashboardEventBus getDashboardEventbus() {
        return ((DashboardUI) getCurrent()).dashboardEventbus;
    }

}
