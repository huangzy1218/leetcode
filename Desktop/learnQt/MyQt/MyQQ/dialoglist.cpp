#include "dialoglist.h"
#include "ui_dialoglist.h"

DiaLogList::DiaLogList(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::DiaLogList)
{
    ui->setupUi(this);
}

DiaLogList::~DiaLogList()
{
    delete ui;
}
