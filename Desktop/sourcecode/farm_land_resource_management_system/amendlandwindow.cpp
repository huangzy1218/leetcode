#include "amendlandwindow.h"
#include "ui_amendlandwindow.h"

AmendLandWindow::AmendLandWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::AmendLandWindow)
{
    ui->setupUi(this);
}

AmendLandWindow::~AmendLandWindow()
{
    delete ui;
}
