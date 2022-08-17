#include "applicantmenu.h"
#include "ui_applicantmenu.h"

ApplicantMenu::ApplicantMenu(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::ApplicantMenu)
{
    ui->setupUi(this);
}

ApplicantMenu::~ApplicantMenu()
{
    delete ui;
}
