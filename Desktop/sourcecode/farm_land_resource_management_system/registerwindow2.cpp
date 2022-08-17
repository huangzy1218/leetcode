#include "registerwindow2.h"
#include "ui_registerwindow2.h"

RegisterWindow2::RegisterWindow2(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::RegisterWindow2)
{
    ui->setupUi(this);
}

RegisterWindow2::~RegisterWindow2()
{
    delete ui;
}
