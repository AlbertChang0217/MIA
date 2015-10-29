package MathFunc;

import Others.Others;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IIIS on 10/28/2015.
 */
public class MathFunc {
    String FuncName;
    Para[] AllPara;
    int NumOfPara;
    int UseFreq;

    public MathFunc(){
        FuncName="";
        AllPara=new Para[100];
        for(int i = 0; i < 100; i++){
            AllPara[i]=new Para();
        }
        NumOfPara=0;UseFreq=0;}

    public void oneUse(){UseFreq++;}
    public void setUseFreq(int freq){UseFreq=freq;}
    public void setFuncName(String funcname){FuncName=funcname;}
    public void setAllPara(Para[] NewParas){
        NumOfPara = NewParas.length;
        for(int i = 0; i < NumOfPara; i++){
            AllPara[i] = NewParas[i];
        }
    }
    public void addPara(Para NewPara){
        AllPara[NumOfPara] = NewPara;
        NumOfPara++;
    }

    public int getUseFreq(){return UseFreq;}
    public int getNumOfPara(){return NumOfPara;}
    public String getFuncName(){return FuncName;}
    public Para[] getAllPara(){return AllPara;}
    public void print(){
        System.out.print("\t"+FuncName+" "+UseFreq+"\n\t\tParameters:\n");
        for(int i = 0; i < NumOfPara; i++){
            AllPara[i].print();
        }
    }

    public void readPara(String upperpath, String funcname) {

        //System.out.println(funcname);

        FuncName=funcname;
        String FilePath = upperpath+"\\"+funcname+"\\"+funcname+".txt";
        File file = new File(FilePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String paraname = null;
            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((paraname = reader.readLine()) != null) {
                AllPara[line-1].loadPara(upperpath+"\\"+funcname, paraname);
                NumOfPara++;
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    public void readParaFreq(String upperpath, String funcname) {
        Others otherFuncs=new Others();

        //System.out.println(funcname);

        FuncName=funcname;
        String FilePath = upperpath+"\\"+funcname+"\\"+funcname+"freq.txt";
        File file = new File(FilePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String freq = null;
            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((freq = reader.readLine()) != null) {
                AllPara[line-1].setUseFreq(otherFuncs.String2int(freq));
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

}
