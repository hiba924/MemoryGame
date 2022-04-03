package com.example.randomnumbermemorization2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ReportFragment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ReportFragment.class })

public class CorrectscreenTest {
    @Test
    public void test_onCreate() {
        PowerMockito.mockStatic(Correctscreen.class);
        Correctscreen activity = PowerMockito.spy(new Correctscreen());

        //PowerMockito.doNothing().when(activity).initScreen();
        PowerMockito.doNothing().when(activity).setContentView(R.layout.activity_correctscreen);
        PowerMockito.doReturn(PowerMockito.mock(AppCompatDelegate.class)).when(activity).getDelegate();

        // Call the method
        activity.onCreate(null);

        verify(activity, times(1)).setContentView(R.layout.activity_correctscreen);
        //verify(activity, times(1)).initScreen();
    }
}