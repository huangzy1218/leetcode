#include "selectidentitywindow.h"
#include "ui_selectidentitywindow.h"

SelectIdentityWindow::SelectIdentityWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::SelectIdentityWindow)
{
    ui->setupUi(this);
}

SelectIdentityWindow::~SelectIdentityWindow()
{
    delete ui;
}
