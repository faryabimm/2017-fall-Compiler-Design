#include <iostream>
#include <cstdio>

using namespace std;

const int Inf = INT_MAX;
int t;
const int Maxt = 365*24;


struct Date {
    int day = 500;
    int hour = 100;

    int val(){
        return (day*24+hour);
    }

    void val2D(int x){
        day = x/24;
        hour = x%24;
    }

    bool operator < (Date &d){
        int x = val();
        int y = d.val();
        return (x<y);
    }

    bool operator > (Date &d){
        int x = val();
        int y = d.val();
        return (x>y);
    }

    bool operator <= (Date &d){
        int x = val();
        int y = d.val();
        return (x <= y);
    }

    bool operator >= (Date &d){
        int x = val();
        int y = d.val();
        return (x >= y);
    }
};

Date infDate;

struct Contract {
    Date date;
    double value = 1.0;

    double eval(){
        if(value>0.0 && date.val()>=t)
            return value;
        else
            return 0.0;
    }
};

Date makeDate(int day = 500, int hour = 25){
    Date x;
    x.day = day;
    x.hour = hour;
    return x;
}

Contract makeContract(Date date, int val=1){
    Contract x;
    x.date = date;
    x.value = val;
    return x;
}

Contract ONE(){
    Contract x = makeContract(infDate,1);
    return x;
}

Contract GIVE(Contract x){
    Contract y = makeContract(x.date,-1*x.value);
    return y;
}

Contract SCALE(double d,Contract x){
    Contract y = makeContract(x.date,d*x.value);
    return y;
}

Contract TRUNCATE(Date d, Contract c){
    Contract y = makeContract(d,c.value);
    return y;
}

Contract AND(Contract c1,Contract c2){
    Date d = ((c1.date>c2.date)?c1.date:c2.date);
    Contract y = makeContract(d,c1.value+c2.value); //TODO check and of contract with itself
    return y;
}

Contract THEN(Contract c1, Contract c2){
    Contract x;
    if(t >= c1.date.val())
        x = c1;
    else
        x = c2;

    return x;
}

////Functions Part
//TODO : define time funcs as a function of this type:
//double TimeFuncName(int arg1){
//    double x = formula ;
//    return x;
//}

int main(){

    //TODO: Set t here
    //TODO: define dates and contracts here

    double sum = 0.0;

    //TODO : sum += $arg1.eval();

    cout<<sum<<endl;
    return 0;
}