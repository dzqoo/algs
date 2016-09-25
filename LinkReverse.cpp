#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <tchar.h>
#include<sstream>
using namespace std;
typedef struct tagSNode
{
    int value;
    tagSNode* pNext;
    tagSNode(int v):value(v),pNext(NULL){}
}SNode;
void  Print(SNode* pHead){
    while(pHead->pNext != NULL){
        cout<<pHead->value<<" ";
        pHead  =  pHead->pNext;
    }
    cout<<endl;
}
void Reverse(SNode* pHead,int from,int to){
    SNode* pCur = pHead->pNext;
    int i;
    for(i= 0;i<from-1;i++){
        pHead = pCur;
        pCur = pCur->pNext;
    }
    SNode* pPre = pCur;
    pCur = pCur->pNext;
    to--;
    SNode* pNext;
    for(;i<to;i++){
        pNext = pCur->pNext;
        pCur->pNext = pHead->pNext;
        pHead->pNext = pCur;
        pPre->pNext = pNext;
        pCur=pNext;
    }
}

void Destroy(SNode* p){
    SNode * next;
    while(p){
        next = p->pNext;
        delete p;
        p =next;
    }
}
int _tmain(int argc,_TCHAR* argv[])
{
    SNode* pHead =new SNode(0);
    int i;
    for(i = 0;i<10;i++){
        SNode* p = new SNode(rand()%100);
        p->pNext = pHead->pNext;
        pHead->pNext = p;
    }
    Print(pHead);
    Reverse(pHead,4,8);
    Print(pHead);;
    Destroy(pHead);
    return 0;
}


