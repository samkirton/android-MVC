package com.architecture.latest.presenter.app.cake;

import android.arch.lifecycle.MutableLiveData;

import com.architecture.latest.R;
import com.architecture.latest.presenter.PresenterTests;
import com.architecture.latest.presenter.interaction.DefaultViewClick;
import com.architecture.latest.presenter.interaction.model.ErrorModel;
import com.architecture.latest.presenter.interaction.model.ExistsLiveData;
import com.architecture.latest.presenter.interaction.model.res.StringResData;
import com.architecture.latest.system.entity.Cake;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CakePresenterTests extends PresenterTests {

    @Mock
    CakeViewModel cakeViewModel;

    @Mock
    ExistsLiveData<List<Cake>> cakes;

    @Mock
    MutableLiveData<Boolean> showProgress;

    @Mock
    MutableLiveData<ErrorModel> error;

    private CakePresenter presenter;

    public CakePresenterTests() {
        super();
    }

    @Before
    public void setup() {

        MockCakeComponent injector = DaggerMockCakeComponent
                .builder()
                .mockRxModule(rxModule)
                .mockCakeRepositoryModule(cakeRepositoryModule)
                .build();

        when(cakeViewModel.cakes()).thenReturn(cakes);
        when(cakeViewModel.showProgress()).thenReturn(showProgress);
        when(cakeViewModel.error()).thenReturn(error);

        presenter = new CakePresenter(cakeViewModel);

        injector.inject(presenter);
    }

    @Test
    public void initialCakesSuccess() {

        // given
        when(cakeViewModel.cakes().exists()).thenReturn(false);

        List<Cake> cakes = new ArrayList<>();
        cakes.add(mock(Cake.class));
        cakes.add(mock(Cake.class));
        cakes.add(mock(Cake.class));

        {
            when(cakeRepositoryModule.cakeRepository().cakes()).thenReturn(Single.just(cakes));
        }

        // when
        presenter.onStart();

        // then
        verify(cakeViewModel.showProgress()).setValue(true);

        verify(cakeViewModel.showProgress()).setValue(false);

        verify(cakeViewModel.cakes()).setValue(cakes);
    }

    @Test
    public void initialCakesFailure() throws Exception {

        // given
        when(cakeViewModel.cakes().exists()).thenReturn(false);

        List<Cake> cakes = new ArrayList<>();
        cakes.add(mock(Cake.class));
        cakes.add(mock(Cake.class));
        cakes.add(mock(Cake.class));

        {
            when(cakeRepositoryModule.cakeRepository().cakes())
                    .thenReturn(Single.<List<Cake>>error(new IOException()))
                    .thenReturn(Single.just(cakes));
        }

        // when
        presenter.onStart();

        // then
        verify(cakeViewModel.showProgress()).setValue(true);

        verify(cakeViewModel.showProgress()).setValue(false);

        verify(cakeViewModel.error()).setValue(new ErrorModel(
                new StringResData(R.string.app_error_title_generic),
                new StringResData(R.string.app_error_body_generic)
        ));

        // and when
        presenter.click().accept(new DefaultViewClick(R.id.inline_error_retry));

        // and then
        verify(cakeViewModel.showProgress(), times(2)).setValue(true);

        verify(cakeViewModel.showProgress(), times(2)).setValue(false);

        verify(cakeViewModel.cakes()).setValue(cakes);
    }
}