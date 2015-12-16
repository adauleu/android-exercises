package fr.android.androidexercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by albandauleu on 16/12/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock LoginActivity activity;
    @InjectMocks LoginPresenter presenter;

    @Test
    public void should_not_log_when_password_is_null() throws Exception {
        //Act
        presenter.checkCredentials(null);

        //Assert
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

    @Test
    public void should_not_log_when_password_length_is_shorter_than_3() throws Exception {
        //Act
        presenter.checkCredentials("r");

        //Assert
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

    @Test
    public void should_log_when_password_is_not_null_and_longer_than_3() throws Exception {
        //Act
        presenter.checkCredentials("correctPassword");

        //Assert
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }
}