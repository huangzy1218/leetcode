#include "enterkeywindow.h"
#include "ui_enterkeywindow.h"

EnterKeyWindow::EnterKeyWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::EnterKeyWindow)
{
    ui->setupUi(this);
}

EnterKeyWindow::~EnterKeyWindow()
{
    delete ui;
}
