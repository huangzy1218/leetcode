#include "deletelandwindow.h"
#include "ui_deletelandwindow.h"

DeleteLandWindow::DeleteLandWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::DeleteLandWindow)
{
    ui->setupUi(this);
}

DeleteLandWindow::~DeleteLandWindow()
{
    delete ui;
}
