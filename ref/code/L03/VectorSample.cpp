#include <bits/stdc++.h>
using namespace std;

vector<int> vec;

int main()
{
    cout<<"vector��ʼ����ռ��С"<<vec.capacity()<<endl;
    // vector
    cout<<"max size: "<<vec.max_size()<<endl;
    int n, t;
    cin>>n;
    for(int i=0; i<n; i++) {
        cin>>t;
        vec.push_back(t);  // ����һ������ĩβ 
    }
    cout<<"����reserve֮ǰ"<<vec.capacity()<<endl; 
    vec.reserve(10);  // Ԥ����ռ��С�� ����vector����, ֮���糬��10��������20
    for(int i=0; i<8; i++) {
        vec.push_back(i);
    }
    cout<<"����reserve֮��"<<vec.capacity()<<endl;

    vec[0] += 10; // ����
    // �����±���ѭ��
    for(int i=0;i<vec.size(); i++) {
        cout<<vec[i]<<" ";  // ��ȡ
    }
    cout<<endl;

    vec.resize(15, -1); // ����Ԫ�ظ��� 
    for(int i=0;i<vec.size(); i++) {// ��ȡ��ǰvector��Ԫ�ظ��� 
        cout<<vec[i]<<" ";  // ��ȡ
    }
    cout<<"\n����resize֮��"<<vec.capacity()<<endl;

    vec.insert(vec.begin()+2, 10); // ��10���뵽vec[2]��
    vec.erase(vec.begin()); // ɾ��vec[0]
    for(int i=0; i<vec.size(); i++) {
        cout<<vec[i]<<" ";
    }
    cout<<endl;

    // ���� iterator��ѭ��
    vector<int>::iterator itr = vec.begin();
    while(itr != vec.end()) {  // Ԫ��δ������
        cout<<*itr<<" ";  // ��ȡiterator��ǰλ�����ֵ
        itr++;            // ��iterator�ƶ�����һ��λ��
    }
    cout<<endl;

    // ���, ɾ��vector�е�ȫ��Ԫ��
    vec.clear();
    cout<<"vecʣ��Ԫ�ظ�����"<<vec.size()<<endl;
    return 0;
}

