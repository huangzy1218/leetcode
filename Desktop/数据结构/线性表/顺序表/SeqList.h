#ifndef SEQLIST_H
#define SEQLIST_H
#include "LinearList.h"

template<class T>
class SeqList: public LinearList<T> {
public:
    SeqList(int = defaultSize);               // ���캯��
    SeqList<T>& operator=(const SeqList<T>&); // ���غ�������ֵ
    SeqList(SeqList<T>&);                     // ���ƹ���
    ~SeqList();                               // ��������
    bool Insert(int i, const T& x);           // ����
    bool Remove(int i);                       // ɾ��
    int Search(T& x) const;                   // ����
    int Locate(int i) const;                  // ��λ
    void Sort();                              // ����
    bool GetData(int i, T& x) const;          // ȡֵ
    void SetData(int i, T& x);                // ��ֵ
    int Size() const;                         // ������ռ�
    int Length() const;                       // �����
    bool IsEmpty() const;                     // �б��
    bool IsFull() const;                      // �б���
    void Input();                             // ����
    void Output();                            // ��� 
protected:
    T* data;                                  // ����
    int MaxSize;                              // �����ռ�
    int last;                                 // ��β
    void ReSize(int);                         // �ı��С
};

// ���캯��
template<typename T>
SeqList<T>::SeqList(int sz)
{
    if (sz > 0) {
        MaxSize = sz;                           // �������ռ�
        last = -1;                              // ��βλ��Ϊ-1
    }
    data = new T[MaxSize];  
    if (data == NULL) {                         // �ڴ����ʧ��
        cerr << "�洢�������" << endl;
        exit(1);
    }
}

// ���ƹ��캯��
template<typename T>
SeqList<T>::SeqList(SeqList<T>& L)
{
    MaxSize = L.MaxSize;   
    last = L.last;
    data = new T[MaxSize];
    if (data == NULL) {
        cerr << "�洢�������" << endl;
        exit(1);
    }
    for (int i = 0; i <= last; i++) {
        data[i] = L.data[i];                    // ���θ�ֵ
    }
}

// ��ֵ���������
template<typename T>
SeqList<T>& SeqList<T>::operator=(const SeqList<T>& L)
{
    // ��ֹ���Ҹ�ֵ
    if (this == &L) {
        return *this;
    }
    delete[] data;                              // �ͷ�ԭ�ռ�
        MaxSize = L.MaxSize;
    last = L.last;
    data = new T[MaxSize];
    if (data == NULL) {
        cerr << "�洢�������" << endl;
        exit(1);
    }
    for (int i = 0; i <= last; i++) {
        data[i] = L.data[i];
    }
}

// �ı��С
template<typename T>
void SeqList<T>::ReSize(int newSize)
{
    if (newSize <= 0) {  // ��Ч�޸�
        cerr << "��Ч�������С" << endl;
        exit(1);
    }
    if (newSize != MaxSize) {                   // ��Ч�޸�
        T* newData = new T[newSize];
        if (newData == NULL) {                  // ���·����ڴ�
            cerr << "�洢�������" << endl;
            exit(1);
        }
        int n = last + 1;                       // Ԫ��ʵ�ʸ��� 
        T* srcptr = data;
        T* desptr = newData;
        while (n--) {
            *desptr++ = *srcptr++;
        }
        delete [] data;                        // �ͷ�ԭ�ڴ�
        data = newData;   
        MaxSize = newSize;
    }
}

// ��������
template<typename T>
SeqList<T>::~SeqList()
{
    delete[] data;
}

// �п�
template<typename T>
bool SeqList<T>::IsEmpty() const
{
    return last == -1;
}

// ����
template<typename T>
bool SeqList<T>::IsFull() const 
{
    return last == MaxSize - 1;
}

// ��ȡ���ռ�
template<typename T>
int SeqList<T>::Size() const
{
    return MaxSize;
}

// ��ȡ��
template<typename T>
int SeqList<T>::Length() const
{
    return last + 1;
}

// ��λ�ڼ���Ԫ�أ���1��ʼ��
template<typename T>
int SeqList<T>::Locate(int i) const
{
    if (i >= 1 && i <= last + 1) {
        return i;
    } else {
        return 0;
    }
}

// ȡ��i��Ԫ��ֵ
template<typename T>
bool SeqList<T>::GetData(int i, T& x) const
{
    if (Locate(i)) {
        x = data[i-1];  
        return true;
    } else {
        return false;
    }
}

//  ����i��Ԫ�ظ�ֵ
template<typename T>
void SeqList<T>::SetData(int i, T& x)
{
    if (Locate(i)) {
        data[i-1] = x;
    }
}

// ����Ԫ��
template<typename T>
int SeqList<T>::Search(T & x) const
{
    for (int i = 0; i <= last; i++) {
        if (data[i] == x) {
            return i + 1;                        // �±���Ԫ��λ�����1                  
        }
    }
    return 0;
}


// ����
template<typename T>
bool SeqList<T>::Insert(int i, const T& x)
{
    if (i == MaxSize - 1) {
        return false;
    }
    if (!Locate(i)) {                           // Խ��
        return false;
    }
    for (int j = last; j >= i - 1; j--) {
        data[j+1] = data[j];                    // ��i���Ԫ����������ƶ�һλ��ע����Ҫ�Ӻ���ǰ���θ�ֵ
    }
    
    data[i-1] = x;                             // ָ��Ԫ�ز���
    ++last;                                    // Ԫ�ظ���+1
    return true;
}


// ɾ��
template<typename T>
bool SeqList<T>::Remove(int i)
{
    if (last == -1) {                          // ���
        return false;
    }
    if (!Locate(i)) {                         // Խ��
        return false;
    }
    for (int j = i - 1; j < last; j++) {      // ��i���Ԫ��������ǰ�ƶ�һλ��ע����Ҫ��ǰ�������θ�ֵ
        data[j] = data[j+1];
    }
    --last;                                   // Ԫ�ظ���-1
    return true;
}


// ����Ԫ��
template<typename T>
void SeqList<T>::Input()
{
    cout << "��ʼ����˳������������Ԫ�ظ���" << endl;
    while (1) {
        cin >> last;
        if (last < MaxSize) {
            break;
        }
        cout << "����������󣬷�Χ���ܳ���" << MaxSize - 1 << endl;
    }
    for (int i = 0; i < last; i++) {
        cin >> data[i];
    }
    --last;                                 // Ԫ�ظ������±����ֵ���1
}

// ���Ԫ��
template<typename T>
void SeqList<T>::Output()
{
   for (int i = 0; i < last; i++)           // ��ʽ�����
   {
       if (i != 0)
       {
           cout << " ";
       }
       cout << data[i];
   }
   cout << endl;
}

// ����
template<typename T>
void SeqList<T>::Sort()                     // �������к���
{
   std::sort(data, data + last);
}

#endif // SEQLIST_H
