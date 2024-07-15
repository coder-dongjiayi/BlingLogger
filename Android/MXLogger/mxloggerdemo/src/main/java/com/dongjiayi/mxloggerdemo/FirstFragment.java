package com.dongjiayi.mxloggerdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.dongjiayi.mxlogger.MXLogger;
import com.dongjiayi.mxlogger.MXStoragePolicyType;
import com.dongjiayi.mxloggerdemo.databinding.FragmentFirstBinding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private  MXLogger logger;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {



        logger = new MXLogger(this.getContext(),
                "com.djy.mxlogger",
                "这是MXLogger头信息",
                "abnijuioijkolojh",

                "abnijuioijkolccc");
        logger.setConsoleEnable(true);
        logger.setLevel(1);
        logger.setMaxDiskSize(1024*1024*10);
      int result =   logger.debug("s","s","{\"kev\":\"value\"}");



        logger.debug("request","mxlogger","this is debug");
        logger.info("request","mxlogger","this is info");
        logger.warn("request","mxlogger","this is warn");
        logger.error("request","mxlogger","this is error");
        logger.fatal("request","mxlogger","this is fatal");

        String loggerKey =  logger.getLoggerKey();
        Log.i("key","loggerKey:" + loggerKey);

       MXLogger.log(loggerKey,"loggerKey",2,"mapName","this is loggerKey log");
       Log.i("path","日志路径" + logger.getDiskCachePath());
        MXLogger.destroy(loggerKey);


       binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("begin","开始写入");
                for (int i=0;i<100000;i++){
                    logger.log("net",0,"android","this is message");
                }

                Log.i("end","结束写入");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}