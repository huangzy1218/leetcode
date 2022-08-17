#ifndef APPLICANTMENU_H
#define APPLICANTMENU_H

#include <QWidget>

namespace Ui {
class ApplicantMenu;
}

class ApplicantMenu : public QWidget
{
    Q_OBJECT

public:
    explicit ApplicantMenu(QWidget *parent = nullptr);
    ~ApplicantMenu();

private:
    Ui::ApplicantMenu *ui;
};

#endif // APPLICANTMENU_H
