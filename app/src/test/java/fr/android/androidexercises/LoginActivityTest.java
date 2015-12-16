package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;

/**
 * Created by albandauleu on 16/12/15.
 */
@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTest {




    LoginActivity activity;

    @Before
    public void before(){
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void should_display_login_at_init() throws Exception {

        //Assert
        Assertions.assertThat(activity.loginLayout).isVisible();
        Assertions.assertThat(activity.loggedText).isGone();
    }

    @Test
    public void should_display_text_when_logged() throws Exception {

        //Act
        activity.logged();

        //Assert
        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void should_check_credentials_when_clicking() throws Exception {
        //Arrange
        String password="password";
        activity.passwordEdit.setText(password);
        activity.presenter = Mockito.mock(LoginPresenter.class);

        //Act
        activity.loginButton.callOnClick();

        //Assert
        Mockito.verify(activity.presenter).checkCredentials(password);
    }
}