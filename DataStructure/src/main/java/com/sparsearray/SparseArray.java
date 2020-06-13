package com.sparsearray;

import org.junit.Test;

import java.io.*;


public class SparseArray {
    @Test
    public  void Sparse() throws IOException {
        FileWriter fileWriter=new FileWriter("H:\\map.data");
        BufferedReader bufferedReader=new BufferedReader(new FileReader("H:\\map.data"));
        //原始的二维数组
        int[][] chessArr1=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[4][9]=2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print("\t"+data);
            }
            System.out.println();
        }
        int sum=0;
        for (int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0)
                    sum++;
            }
        }
        //二维数组转稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        int count=0;
        for (int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0) {
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.print("\t"+data);
            }
            System.out.println();
        }
        //写入文件
        for (int i=0;i<sparseArr.length;i++){
            for(int j=0;j<3;j++){
                fileWriter.write(sparseArr[i][j]+"\t");
            }
            fileWriter.write("\r\n");
        }
        fileWriter.close();


        //稀疏数组转二维数组
        int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        int sparseArr2[][]=new int[sum+1][3];
        //读入文件
        String line;
        int row=0;
        while ((line=bufferedReader.readLine())!=null){
            String[] temp=line.split("\t");
            for(int i=0;i<temp.length;i++){
                sparseArr2[row][i]=Integer.parseInt(temp[i]);
            }
            row++;
        }
        bufferedReader.close();
        for (int i=1;i<sparseArr2.length;i++){
           chessArr2[sparseArr2[i][0]][sparseArr2[i][1]]=sparseArr2[i][2];
        }

        for (int[] rows : chessArr2) {
            for (int data : rows) {
                System.out.print("\t"+data);
            }
            System.out.println();
        }


    }



}
