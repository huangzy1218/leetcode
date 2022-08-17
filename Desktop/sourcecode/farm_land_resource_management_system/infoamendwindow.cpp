#include "infoamendwindow.h"
#include "ui_infoamendwindow.h"

InfoAmendWindow::InfoAmendWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::InfoAmendWindow)
{
    ui->setupUi(this);
}

InfoAmendWindow::~InfoAmendWindow()
{
    delete ui;
}
