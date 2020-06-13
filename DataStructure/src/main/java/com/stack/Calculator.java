package com.stack;

import java.util.Stack;

public class Calculator {
    private Stack<Integer> numStack=new Stack();
    private Stack<Character> opStack=new Stack();

    public int calculator(String expression){
        int num1;
        int num2;
        int oper;
        int res;
        int index=0;
        String keepNum="";
        while (true) {
            char c = expression.substring(index, index + 1).charAt(0);
            if (isOper(c)){
                if(opStack.empty()){
                    opStack.push(c);
                }else if(priority(c)<=priority(opStack.peek())){
                    num1=numStack.pop();
                    num2=numStack.pop();
                    oper=opStack.pop();
                    res=cal(num1,num2,oper);
                    numStack.push(res);
                    opStack.push(c);
                }else opStack.push(c);
            }
            else {
               //numStack.push(c-48);
                keepNum+=c;
                if(index==expression.length()-1)numStack.push(Integer.parseInt(keepNum));
                else {
                    if (isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        while (true){
            if(opStack.empty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=opStack.pop();
            res=cal(num1,num2,oper);
            numStack.push(res);
        }
        return numStack.pop();
    }
    public int priority(int opration){
        if(opration=='+'||opration=='-')return 0;
        else if(opration=='*'||opration=='/') return 1;
        else return -1;
    }
    public boolean isOper(int num){
        if(num=='+'||num=='-'||num=='*'||num=='/')return true;
        else return false;
    }
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+': res= num1+num2;break;
            case '-': res= num2-num1;break;
            case '*': res= num1*num2;break;
            case '/': res= num2/num1;break;
            default:break;
        }
        return res;
    }
}
