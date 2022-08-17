#include "findlandwindow.h"
#include "ui_findlandwindow.h"

FindLandWindow::FindLandWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::FindLandWindow)
{
    ui->setupUi(this);
}

FindLandWindow::~FindLandWindow()
{
    delete ui;
}
