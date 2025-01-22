package notificationsTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reminder.notifications.Notification;
import org.reminder.notifications.NotificationManager;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {

    private NotificationManager manager;
    private Notification notification1;
    private Notification notification2;

    @BeforeEach
    void setUp() {
        manager = new NotificationManager();
        notification1 = new Notification("Notification 1");
        notification2 = new Notification("Notification 2");
    }

    @Test
    void testAddNotification() {
        manager.addNotification(notification1);
        assertEquals(1, manager.getNotifications().size());
        assertTrue(manager.getNotifications().contains(notification1));
    }

    @Test
    void testRemoveNotification() {
        manager.addNotification(notification1);
        manager.addNotification(notification2);
        manager.removeNotification(notification1);
        assertEquals(1, manager.getNotifications().size());
        assertFalse(manager.getNotifications().contains(notification1));
    }

    @Test
    void testRemoveAllNotifications() {
        manager.addNotification(notification1);
        manager.addNotification(notification2);
        manager.removeAllNotifications();
        assertEquals(0, manager.getNotifications().size());
    }

    @Test
    void testGetNotifications() {
        manager.addNotification(notification1);
        manager.addNotification(notification2);
        ArrayList<Notification> notifications = manager.getNotifications();
        assertEquals(2, notifications.size());
        assertTrue(notifications.contains(notification1));
        assertTrue(notifications.contains(notification2));
    }

    @Test
    void testGetNotificationByName() {
        manager.addNotification(notification1);
        manager.addNotification(notification2);
        Notification result = manager.getNotification("Notification 1");
        assertNotNull(result);
        assertEquals("Notification 1", result.getTitle());
    }

    @Test
    void testGetNotificationByNameNotFound() {
        manager.addNotification(notification1);
        Notification result = manager.getNotification("Non-existing");
        assertNull(result);
    }
}
