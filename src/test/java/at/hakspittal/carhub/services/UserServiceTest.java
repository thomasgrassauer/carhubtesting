package at.hakspittal.carhub.services;

import at.hakspittal.carhub.User;
import at.hakspittal.carhub.peristence.DataPersistence;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    DataPersistence persistence;

    private UserService target;

    @Before
    public void setUp() {
        Mockito.when(persistence.userExists(Matchers.eq("admin"))).thenReturn(true);
        Mockito.when(persistence.storeUser(Matchers.any())).thenReturn(true);
        Mockito.when(persistence.login(Matchers.eq("admin"), Matchers.eq("admin"))).thenReturn(true);

        target = new UserService(persistence);
    }

    @Test
    public void testRegisterUserWithNullUser() {
        // given
        final User user = null;

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.ERROR, actual);
    }

    @Test
    public void testRegisterUserWithUserAndNullUsername() {
        // given
        final User user = new User(null);

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.ERROR, actual);
    }

    @Test
    public void testRegisterUserWithUserAndExistingUsername() {
        // given
        final User user = new User("admin", "password", "zip", "city", "first", "last");

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.USER_EXISTS, actual);
    }

    @Test
    public void testRegisterUserWithUserAndUniqueUsernameButMissingData() {
        // given
        final User user = new User("unique");

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.ERROR, actual);
    }

    @Test
    public void testRegisterUserWithUserAndUniqueUsernameWithMissingPassword() {
        // given
        final User user = new User("unique", "", "zip", "city", "first", "last");

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.ERROR, actual);
    }

    @Test
    public void testRegisterUserWithUserAndUniqueUsernameWithMissingZipCode() {
        // given
        final User user = new User("unique", "password", "", "city", "first", "last");

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.ERROR, actual);
    }

    @Test
    public void testRegisterUserWithUserAndUniqueUsernameWithMissingCity() {
        // given
        final User user = new User("unique", "password", "zip", "", "first", "last");

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.ERROR, actual);
    }

    @Test
    public void testRegisterUserWithUserAndUniqueUsernameWithMissingFirstname() {
        // given
        final User user = new User("unique", "password", "zip", "city", "", "last");

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.ERROR, actual);
    }

    @Test
    public void testRegisterUserWithUserAndUniqueUsernameWithMissingLastname() {
        // given
        final User user = new User("unique", "password", "zip", "city", "first", "");

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.ERROR, actual);
    }

    @Test
    public void testRegisterUserWithUserAndUniqueUsernameWithValuesOK() {
        // given
        final User user = new User("unique", "password", "zip", "city", "first", "last");

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.OK, actual);
    }

    @Test
    public void testRegisterUserWithUserAndUniqueUsernameWithValuesOKButFailingPersistence() {
        // given
        final User user = new User("unique", "password", "zip", "city", "first", "last");

        Mockito.when(persistence.storeUser(Matchers.any())).thenReturn(false);

        // when
        final UserService.RegistrationResult actual = target.registerUser(user);

        // then
        assertEquals(UserService.RegistrationResult.ERROR, actual);
    }

    @Test
    public void testLoginWithUsernameAndPasswordOK() {
        // given
        final String username = "admin";
        final String password = "admin";

        // when
        final boolean actual = target.login(username, password);

        // then
        assertTrue(actual);
    }

    @Test
    public void testLoginWithUsernameAndPasswordFailing() {
        // given
        final String username = "admin";
        final String password = "password";

        // when
        final boolean actual = target.login(username, password);

        // then
        assertFalse(actual);
    }

    @Test
    public void testLoginWithNullUsernameAndPassword() {
        // given
        final String username = null;
        final String password = "password";

        // when
        final boolean actual = target.login(username, password);

        // then
        assertFalse(actual);
    }

    @Test
    public void testLoginWithNonExistingUsernameAndNullPassword() {
        // given
        final String username = "username";
        final String password = null;

        // when
        final boolean actual = target.login(username, password);

        // then
        assertFalse(actual);
    }

    @Test
    public void testLoginWithExistingUsernameAndNullPassword() {
        // given
        final String username = "admin";
        final String password = null;

        // when
        final boolean actual = target.login(username, password);

        // then
        assertFalse(actual);
    }
}
