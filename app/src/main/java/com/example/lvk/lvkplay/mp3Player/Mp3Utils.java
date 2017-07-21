package com.example.lvk.lvkplay.mp3Player;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lavith.edam on 7/21/2017.
 */

public class Mp3Utils {
    private List<File> fileList;

    private class Mp3Filter implements FilenameFilter
    {
        public boolean accept(File dir, String name)
        {
            return (name.endsWith(".mp3"));
        }

    }
    /**
     * reads the file names and store in list
     * @param mainPath the path to look at, example /sdcard
     */
    public List<String> getMp3Files(String mainPath)
    {
        List<String> filePaths=new ArrayList<String>();
        File home = new File(mainPath);
        if (fileList == null)
            fileList = new ArrayList<File>();
        Mp3Filter mp3Filter = new Mp3Filter();
        if (home.listFiles(mp3Filter) != null && home.listFiles(mp3Filter).length > 0)
        {
            for (File file : home.listFiles(mp3Filter))
            {
                //this is the file path you want to pass to the player
                filePaths.add(file.getPath());
                fileList.add(file);
            }
        }
        return filePaths;
    }
}
