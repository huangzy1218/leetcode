#include "addlandwindow.h"
#include "ui_addlandwindow.h"

AddLandWindow::AddLandWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::AddLandWindow)
{
    ui->setupUi(this);
}

AddLandWindow::~AddLandWindow()
{
    delete ui;
}
